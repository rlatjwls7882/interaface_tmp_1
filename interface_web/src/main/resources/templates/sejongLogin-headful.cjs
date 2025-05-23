const puppeteer = require('puppeteer');

async function sejongLogin(studentId, password) {
  const browser = await puppeteer.launch({ headless: false });
  const page = await browser.newPage();

  // ✅ confirm 창 무력화 (보안프로그램 설치 거절)
  await page.evaluateOnNewDocument(() => {
    window.confirm = (msg) => {
      if (msg.includes('보안프로그램을 설치하셔야')) {
        return false; // ❌ 취소
      }
      return true; // ✅ 그 외는 확인
    };
  });

  // ✅ 모든 dialog 감지 및 자동 처리
  page.on('dialog', async dialog => {
    const msg = dialog.message();
    console.log(`📢 알림창: ${msg}`);

    if (msg.includes('키보드보안 프로그램 설치를 취소하였습니다')) {
      await dialog.accept(); // ✅ 확인
    } else {
      await dialog.dismiss(); // ❌ 나머지 취소
    }
  });

  await page.goto('https://portal.sejong.ac.kr/', { waitUntil: 'domcontentloaded' });

  // ✅ 세종대 JS 초기화 대기 (입력창 활성화 & focus 대기)
  await page.waitForFunction(() => {
    const input = document.querySelector('input[name="id"]');
    return input && document.activeElement === input && input.offsetParent !== null;
  }, { timeout: 15000 });

  // ✅ 학번, 비밀번호 입력 및 이벤트 발생
  await page.evaluate((id, pw) => {
    const idInput = document.querySelector('input[name="id"]');
    const pwInput = document.querySelector('input[name="password"]');

    idInput.value = id;
    pwInput.value = pw;

    idInput.dispatchEvent(new Event('input', { bubbles: true }));
    idInput.dispatchEvent(new Event('change', { bubbles: true }));

    pwInput.dispatchEvent(new Event('input', { bubbles: true }));
    pwInput.dispatchEvent(new Event('change', { bubbles: true }));
  }, studentId, password);

  await new Promise(resolve => setTimeout(resolve, 500));

  await page.click('a#loginBtn');

// 👉 강제 5초 대기 후 URL 직접 체크
await new Promise(resolve => setTimeout(resolve, 5000));

const currentUrl = page.url();
console.log('📌 현재 URL:', currentUrl);

// ✅ 성공 판정 기준 강화
if (
  currentUrl.includes('/main/') || 
  currentUrl.includes('/user/index.do') || 
  currentUrl.includes('doSsoLogin')
) {
  await browser.close();
  return {
    success: true,
    message: '로그인 성공',
    userInfo: { loginUrl: currentUrl }
  };
} else {
  await browser.close();
  return {
    success: false,
    message: '로그인 실패 또는 리디렉션 없음',
    url: currentUrl
  };
}

}

module.exports = { sejongLogin };

// back.cjs
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const { sejongLogin } = require('./sejongLogin-headful.cjs');

const app = express();
const PORT = 3000;

app.use(cors());
app.use(bodyParser.json());
app.use(express.static('public'));

app.post('/api/login', async (req, res) => {
  const { email, password } = req.body;

  try {
    const result = await sejongLogin(email, password);

    if (result.success) {
      const cpr = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email }),
      });
      res.json({ success: true, userInfo: result.userInfo || {}, message: result.message });
    } else {
      res.status(401).json({ success: false, message: result.message });
    }
  } catch (err) {
    console.error('❌ 서버 오류:', err);
    res.status(500).json({ success: false, message: '서버 내부 오류: ' + err.message });
  }
});

app.listen(PORT, () => {
  console.log(`✅ 서버 실행 중: http://localhost:${PORT}`);
});

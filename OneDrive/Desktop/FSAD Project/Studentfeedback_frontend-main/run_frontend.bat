@echo off
cd /d "%~dp0"
echo Starting Frontend...
npm install
npm run dev
pause

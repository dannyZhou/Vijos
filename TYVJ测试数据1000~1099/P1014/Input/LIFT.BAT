@echo off
if "%1"=="" goto loop
copy mul%1.in input%1.txt >nul
del mul%1.in
goto end
:loop
for %%i in (1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20) do call %0 %%i
:end

@echo off
if "%1"=="" goto loop
copy compages%1.in input%1.txt >nul
del compages%1.in
goto end
:loop
for %%i in (1 2 3 4 5 6 7 8 9 10) do call %0 %%i
:end
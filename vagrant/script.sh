#! /bin/bash

echo ':::::::::::::::::::::-1'
dir
rm -r bot
echo ':::::::::::::::::::::0'
dir
mkdir bot
echo ':::::::::::::::::::::1'
dir
cd bot

apt-get update
apt-get install maven -y

git clone https://github.com/nekt2111/halushka_pampushka_bot.git
echo ':::::::::::::::::::::2'
cd halushka_pampushka_bot
#git pull origin
dir
echo ':::::::::::::::::::::3'
dir
cd bot
echo '💃🕺 хто не скаче, той москаль 💃🕺'
sleep 1
echo '.'
sleep 1
echo '..'
sleep 1
echo '...'
sleep 0.5s
echo '🕺💃 хто скаче (найкращі скакуни): 🕺💃'
sleep 0.5s
echo '    🥳 tsymbal'
sleep 0.5s
echo '    🤸 halushka'
sleep 0.5s
echo '    🧑 jereb'
sleep 0.5s
echo '    🌹 jerebez'
sleep 0.5s
echo '    🩰 baba valya'
sleep 0.5s
echo '    🍺 kpi'
sleep 0.5s
echo '    🍻 fiot'
sleep 0.5s
echo '    🚴 rolik'
sleep 0.5s
echo '    🎺 stefania'
sleep 0.5s
echo '    👯 eurovision'
sleep 0.5s
cd appz_bot_example-master

mvn clean install && cd hello_bot && mvn exec:java -Dexec.mainClass="kpi.acts.appz.bot.hellobot.HelloWorldBot" -Dexec.args="5303909693:AAGH-wVmTPhhn8mSCvWgezuNGdwRdAXSplM KPI2LabBot"
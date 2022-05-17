#! /bin/bash
rm -r bot
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
cd appz_bot_example-master
cd hello_bot
cat pom.xml
echo '8888888888888888888888888888888888888888888888888888888888888'
echo pom.xml
cd ..
echo '9999999999999999999999999999999999999999999999999999999999'

mvn clean install && cd hello_bot && mvn exec:java -Dexec.mainClass="kpi.acts.appz.bot.hellobot.HelloWorldBot" -Dexec.args="5303909693:AAGH-wVmTPhhn8mSCvWgezuNGdwRdAXSplM KPI2LabBot"
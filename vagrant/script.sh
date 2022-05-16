#! /bin/bash
mkdir bot
echo ':::::::::::::::::::::1'
dir
cd bot

apt-get update
apt-get install maven -y

git clone https://github.com/nekt2111/halushka_pampushka_bot.git
echo ':::::::::::::::::::::2'
dir
cd halushka_pampushka_bot
echo ':::::::::::::::::::::3'
dir
cd bot
cd appz_bot_example-master

mvn clean install && cd hello_bot && mvn exec:java -Dexec.mainClass="kpi.acts.appz.bot.hellobot.HelloWorldBot" -Dexec.args="5303909693:AAGH-wVmTPhhn8mSCvWgezuNGdwRdAXSplM KPI2LabBot"
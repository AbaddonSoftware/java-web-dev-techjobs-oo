#!/usr/bin/env bash

AvailableCode=( "Unit2: Graded Assignment 2"=org.launchcode.techjobs_oo.Main
                "Unit2: Graded Assignment 2 Job Tests"=org.launchcode.techjobs_oo.tests.JobTest  )
                
                # add additional code above as "Name to be used in launcher"=codespackage.ClassName
                # no spaces may be used outside of the "quoted" portions including between the
                # equals (=) sign

                # changed this to use arrays so that it won't sort by hash
                
                # Tests will be run if the Name includes the word test. Do not include test
                # in names that do not have Tests

for Element in "${AvailableCode[@]}"
do
  Entry=( $(echo $Element | tr "=" "\n" | sed -e 's/_/-underscore-/g' -e 's/ /_/g' ) )
  Name=(${Entry[0]})
  Class=(${Entry[1]})
  Names+=(${Name})
  Classes+=(${Class})
done

if [ ! -d out/repl.it ]; then
  echo "These sources have not been compiled yet."
  echo "YOU WILL NEED TO COMPILE THEM TO USE THIS SCRIPT."
  echo "This message only appears when they are not present."
  echo ""
  bash compile.sh
fi


cd out/repl.it/
while true; do
INDEX=1;
for Name in "${Names[@]}"; do
 Name=$(echo $Name | sed -e 's/_/ /g' -e 's/-underscore-/_/')
 echo "$INDEX $Name"
 ((INDEX=INDEX+1))
done

echo
echo "Type 'exit' to exit the loop"                     
echo 
echo "Enter a number to test the code"
read INDEX
[ "${INDEX,,}" == "exit" ] && break 
if [[ "${Names[$INDEX-1],,}" == *"test"* ]]; 
then Test="org.junit.runner.JUnitCore" 
else Test="" 
fi
clear; java -cp .:./../../lib/* $Test $(echo ${Classes[$INDEX-1]} | sed -e 's/_/ /g' -e 's/-underscore-/_/')
echo
echo "----------------------------------------------------"
echo "This code has ended. Press any key to return to menu"
read -n 1 -s -r
clear
done


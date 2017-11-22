
#!/bin/sh

for i in $(seq 1 100)
do 
  str=${i}: 
  if [ $(expr $i % 3) -eq 0 ]
  then
    str=${str}Fizz
  fi
  if [ $(expr $i % 5) -eq 0 ]
  then
    str=${str}Buzz
  fi
  echo $str
done

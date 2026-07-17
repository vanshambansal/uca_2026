

#!/bin/bash

cat > employee.txt << EOF
Alice,Engineering,50,40
Bob,Marketing,35,38
Charlie,Engineering,60,45
David,HR,30,40
Eva,Engineering,55,35
EOF


echo "---Task 1---"
echo "Names and Departments"

awk -F, '{print $1, $2 }' employee.txt

echo

echo "---Task 2---"
echo "Engineering Employees"
awk -F, '$2=="Engineering"' employee.txt

echo

echo "---Task 3---"
echo "Gross Pay"
awk -F, '{print $1, "gross pay: $" $3*$4}' employee.txt


echo

echo "---Task 4---"
echo "Line Number and Field Count"
awk -F, '{print NR,"("NF" fields):", $0}' employee.txt

echo

echo "--Task 5---"
echo "Engineering Payroll"

awk -F, '
BEGIN{
	total = 0
}
$2 == "Engineering"{
	total += $3*$4
}
END{
	print "Total Engineering Cost: $" total
	

}' employee.txt






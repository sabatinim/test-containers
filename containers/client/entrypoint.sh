#!/bin/bash

mysql --host=mysql -uroot -ppwd < employees.sql
echo "EMPLOYEES schema created!"
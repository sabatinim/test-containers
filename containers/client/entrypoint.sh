#!/bin/bash

case "$@" in

schema)
  mysql --host=mysql -uroot -ppwd < employees.sql
  echo "EMPLOYEES schema created!"
  ;;
demo)
    mysql --host=mysql -uroot -ppwd < demo.sql
  echo "Could load demo data!"
  ;;
esac


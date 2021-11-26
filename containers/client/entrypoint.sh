#!/bin/bash

case "$@" in
schema)
  mysql --host=mysql -uroot -ppwd < employees.sql
  echo "EMPLOYEES schema created!"
  ;;
other)
  echo "Could load demo data!"
  ;;
esac


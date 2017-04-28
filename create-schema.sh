DATABASE=${1:-crossover}   
docker exec -it mysql bash -c "mysql -uroot -padmin -e 'CREATE DATABASE $DATABASE'"


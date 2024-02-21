reset

clear

cd ..

docker-compose -f development.yaml down

docker-compose -f development.yaml up --build

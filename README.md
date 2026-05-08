Script para crear la base de datos 

create database card_prueba;


curl 

## Emitir tarjeta

postman request POST 'http://localhost:8080/api/cards' \
--header 'Content-Type: application/json' \
--body '{
"productId":"123456",
"holderName":"jonathan romero"
}'

## Activar tarjeta
postman request POST 'http://localhost:8080/api/cards/1/active' \
--body ''

## Bloquear tarjeta
postman request POST 'http://localhost:8080/api/cards/1/block' \
--body ''

##  Consultar tarjeta
postman request 'http://localhost:8080/api/cards/1'

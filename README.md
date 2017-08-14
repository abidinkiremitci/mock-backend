# MOCK-APP NOTES


## SpringBoot Run Config:
VM Options: -Dspring.config.name=application.dev


## H2-Console:
http://localhost:8080/h2-console/
	jdbc driver: org.h2.Driver
	jdbc url: jdbc:h2:mem://localhost/~/mockbackendDB;MODE=MYSQL

## Basic OAuth2:
    -> Getting Token by using basin auth
    post
    localhost:8081/oauth/token?grant_type=client_credentials
    Header:
    Accept:application/json
    Authorization:Basic Y3VybC1jbGllbnQ6Y2xpZW50LXNlY3JldA==
    -> Getting resources by using token
    get
    http://localhost:8080/api/user/queryUserByEmail?email=test@test.com
    Header:
    Authorization:Bearer <TOKEN>
    
    -> Curl test
    echo "Good client can pass"
    TOKEN=$(curl -X POST --silent --noproxy localhost -u curl-client:client-secret 'localhost:8081/oauth/token?grant_type=client_credentials' -H "Accept: application/json")
    echo "Got token $TOKEN"
    curl --noproxy localhost localhost:8080/todos -H "Authorization: Bearer $TOKEN"
    echo ''
    echo "Wrong client_id"
    TOKEN=$(curl -X POST --silent --noproxy localhost -u wrong_client_id:client-secret 'localhost:8081/oauth/token?grant_type=client_credentials' -H "Accept: application/json")
    echo "Got token $TOKEN"
    
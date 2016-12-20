# RestApplicationTest
This repo contains test for a software company

The project used Spring boot and REST apache cxf webservice. The data will be stored in hsqldb provided by spring boot and 
services deployed in embedded tomcat server
Following are the REST services -

POST
http://localhost:8080/services/articles/create

PUT
http://localhost:8080/services/articles/update

GET
http://localhost:8080/services/articles/retrievearticle/3

http://localhost:8080/services/articles/retrievearticlesofkeyword/emiss

http://localhost:8080/services/articles/retrievearticlesofauthor/Peter Philips

http://localhost:8080/services/articles/retrievearticlesofperiod/28-09-2015/30-09-2015

DELETE
http://localhost:8080/services/articles/delete/2


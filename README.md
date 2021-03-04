# linktracker
#POST para crear un link  con password:

URL: http://localhost:8080/link

BODY: {"url":"https://stackoverflow.com","password":"gise"}

*Ressponse*:{"linId": 0 }

#GET para solicitar redireccion a la url asociada al linkID y a la password:

URL:http://localhost:8080/link/0?password=gise

#POST para invalidar un link:

URL:http://localhost:8080/invalidate/0

#GET para solicitar la cantidad de veces que se redicciono a la url asociada al linkId 0:

URL:http://localhost:8080/metrics/0

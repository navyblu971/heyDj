//La variable express nous permettra d'utiliser les fonctionnalités du module Express.  
var express = require('express'); 
var mysql = require('mysql');
// Nous définissons ici les paramètres du serveur.
const port = process.env.APP_PORT;
const mysql_port = parseInt(process.env.APP_MYSQL_PORT);
const mysql_ip = process.env.APP_MYSQL_IP
const mysql_user = process.env.APP_MYSQL_USER
const mysql_password = process.env.APP_MYSQL_PWD
var hostname = '0.0.0.0'; 
//var port = 8181; 
 
var app = express(); 



var con = mysql.createConnection({
  host: mysql_ip,
  user: mysql_user,
  password: "password",
  database: "heyDjBase", 
   debug : true
  /*port : mysql_port*/
});

con.connect(function (err)
{
  if (err)
  console.log ("mysql connexion err :" + err.message)

});

app.get('/requestSong.html', function(req, res) {
  res.sendFile( __dirname  + '/requestSong.html');
});


app.post('/post.html', function(req, res) {
  var p1 = req.body.p1; 
  console.log("p1=" + p1);
});


app.get('/', function (req, res) {
    res.render('index', {});
  });

app.get("/url", (req, res, next) => {
    res.json(["Tony","Lisa","Michael","Ginger","Food"]);
   });



   app.get("/playlist/insert/:barId/:uri", (req, res, next) => {


    con.query("INSERT INTO `songs` ( `uri`,  `idBar`) VALUES ( '" + req.params.uri+"', '"+ req.params.barId +"')" , function(err, rows, fields) {
      if (err)
        console.log('error while insert');
      else
        console.log('insert ok');


        //res.send("insert ok")
        /*
        rows.forEach( (row) => {
          console.log(`${row.id} is in ${row.uri}`);
        });*/
    });
    //res.json({message : "you are listing to song no " + req.params.barId});
    //res.json (rows)
   });

app.get("/playlist/:barId", (req, res, next) => {


    con.query("SELECT id, uri  FROM songs where idBar="+ req.params.barId, function(err, rows, fields) {
      if (!err)
        console.log('The solution is: ', rows);
      else
        console.log('Error while performing Query. err =' + err.message);


        res.json (rows)
        /*
        rows.forEach( (row) => {
          console.log(`${row.id} is in ${row.uri}`);
        });*/
    });
    //res.json({message : "you are listing to song no " + req.params.barId});
    //res.json (rows)
   });


  
  app.delete('/song/:song_id', (req, res) => {
    return res.send(
      `DELETE HTTP method on song /${req.params.song_id} `,
    );
  });
  
// Démarrer le serveur 
app.listen(port, hostname, function(){
	console.log("Mon serveur fonctionne sur http://"+ hostname +":"+port+"\n"); 
});
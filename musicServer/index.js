//La variable express nous permettra d'utiliser les fonctionnalités du module Express.  
var express = require('express'); 
 
// Nous définissons ici les paramètres du serveur.
var hostname = 'localhost'; 
var port = 3000; 
 
var app = express(); 

var mysql = require('mysql');

var con = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "mypass123",
  database: "heyDjDB" , 
  port : 33060
});


try {

con.connect(function(err) {
  if (err) throw err;
  console.log("step 1");
  con.query("SELECT * FROM songRequest", function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});

} catch (e)
{
  console.log(e); 
}

app.get('/', function (req, res) {
    res.render('index', {});
  });

app.get("/url", (req, res, next) => {
    res.json(["Tony","Lisa","Michael","Ginger","Food"]);
   });



   app.get("/song/:song_id", (req, res, next) => {
    res.json({message : "you are listing to song no " + req.params.song_id});
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
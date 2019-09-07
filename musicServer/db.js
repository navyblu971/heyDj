


var hostname = 'localhost'; 
var port = 3000; 
 


var mysql = require('mysql');

var con = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "fatexide",
  database: "heyDjDB" , 
  port : 33060
});




con.connect(function(err) {
  if (err) throw err;
  console.log("step 1");
  con.query("SELECT * FROM songRequest", function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});





var hostname = 'localhost'; 
var port = 3000; 
 


var mysql = require('mysql');

var con = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "password",
  database: "heyDjBase" , 
  port : 33060
});




/*

var id = 1
con.connect(function(err , id ) {
  if (err) throw err;
  console.log("step 1");
  con.query("SELECT * FROM songs where bar="+ id, function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});
*/

con.connect();
var id = 1
console.log ("SELECT * FROM songs where bar="+ id)
con.query("SELECT * FROM songs where idBar="+ id, function(err, rows, fields) {
  if (!err)
    console.log('The solution is: ', rows);
  else
    console.log('Error while performing Query.');
    
    /*
    rows.forEach( (row) => {
      console.log(`${row.id} is in ${row.uri}`);
    });*/
});

con.end();

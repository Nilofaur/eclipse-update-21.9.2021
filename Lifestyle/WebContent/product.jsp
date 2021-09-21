<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
></script>
<!DOCTYPE html>
<html>
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
  rel="stylesheet"
/>
<p> PRODUCTS </p>
<!-- MDB -->
<script> 
/*
=====> Checking browser support.
 //This step might not be required because most modern browsers do support HTML5.
 */
 //Function below might be redundant.
function CheckBrowser() {
    if ('localStorage' in window && window['localStorage'] !== null) {
        // We can use localStorage object to store data.
        return true;
    } else {
            return false;
    }
}

</script>
<script> 
//Dynamically populate the table with shopping list items.
//Step below can be done via PHP and AJAX, too.
function doShowAll() {
  if (CheckBrowser()) {
      var key = "";
      var list = "<tr><th>Item</th><th>Value</th></tr>\n";
      var i = 0;
      //For a more advanced feature, you can set a cap on max items in the cart.
      for (i = 0; i <= localStorage.length-1; i++) {
          key = localStorage.key(i);
          list += "<tr><td>" + key + "</td>\n<td>"
                  + localStorage.getItem(key) + "</td></tr>\n";
      }
      //If no item exists in the cart.
      if (list == "<tr><th>Item</th><th>Value</th></tr>\n") {
          list += "<tr><td><i>empty</i></td>\n<td><i>empty</i></td></tr>\n";
      }
      //Bind the data to HTML table.
      //You can use jQuery, too.
      document.getElementById('list').innerHTML = list;
  } else {
      alert('Cannot save shopping list as your browser does not support HTML 5');
  }
}

</script>

<script>
function SaveItem() {

    var name = document.forms.ShoppingList.name.value;
    var data = document.forms.ShoppingList.data.value;
    localStorage.setItem(name, data);
    doShowAll();

}
</script>

<script type="text/javascript">
function SaveItem() {
    var name = $("#name").val();
    var data = $("#data").val();
    localStorage.setItem(name, data);
    doShowAll();
}


</script>

<script>

//Change an existing key-value in HTML5 storage.
function ModifyItem() {
    var name1 = document.forms.ShoppingList.name.value;
    var data1 = document.forms.ShoppingList.data.value;
    //check if name1 is already exists

//Check if key exists.
            if (localStorage.getItem(name1) !=null)
            {
              //update
              localStorage.setItem(name1,data1);
              document.forms.ShoppingList.data.value = localStorage.getItem(name1);
            }

    doShowAll();
}


</script>

<script>
function RemoveItem()
{
var name=document.forms.ShoppingList.name.value;
document.forms.ShoppingList.data.value=localStorage.removeItem(name);
doShowAll();
}


</script>

<script>
function ClearAll() {
    localStorage.clear();
    doShowAll();
}

</script>

<head>
<title>HTML5 Local Storage Project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="rating" content="General">
<meta name="expires" content="never">
<meta name="language" content="English, EN">
<meta name="description" content="Shopping cart project with HTML5 and JavaScript">
<meta name="keywords" content="HTML5,CSS,JavaScript, html5 session storage, html5 local storage">
<meta name="author" content="dcwebmakers.com">
<script src="Storage.js"></script>
<link rel="stylesheet" href="StorageStyle.css">
</head>

<form name="ShoppingList">
    <fieldset>
        <legend>Shopping cart</legend>
        <label>Item: <input type="text" name="name"></label>
        <label>Quantity: <input type="text" name="data"></label>

        <input type="button" value="Save"   onclick="SaveItem()">
        <input type="button" value="Update" onclick="ModifyItem()">
        <input type="button" value="Delete" onclick="RemoveItem()">
    </fieldset>
    <div id="items_table">
        <h2>Shopping List</h2>
        <table id="list"></table>
        <label><input type="button" value="Clear" onclick="ClearAll()">
        * Delete all items</label>
    </div>
   <script> localStorage.myProperty="myValue";</script>

      <script>   delete localStorage.myProperty;</script>
    
</form>

<body onload="doShowAll()">


</html>
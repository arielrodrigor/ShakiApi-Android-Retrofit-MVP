<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Script de php</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
  
<div class="container">
  <div class="row">
    <div class="col-sm-5 col-md-6">
            <fieldset>
            <form action="guia.php" method="POST">
            <div class="form-group">
                <h3>Ingrese el numero para generar la tabla</h3>
                <input class="form-control"type="number" name="table" id="table"/>
                <br>
                <input  class="form-control" type="submit" name="send" id="send" value="Enviar"/>
            </div>
            
            </form>
            <br>
            <?php
                if(isset($_POST['table'])):
                $table = isset($_POST['table']) ? $_POST['table'] : 0;
                
            for($i=0;$i<=10;$i++){
                $result = $table*$i;
                echo "<p> $table x $i = $result </p>";
            }
            endif;
            ?>
            </fieldset>
   
    </div>
 
    <div class="col-sm-5 offset-sm-2 col-md-6 offset-md-0">
    <fieldset>
            <form action="guia.php" method="post">
            <div class="form-group">
                <h3>Calcular potencia</h3>
                <p>Base</p>
                <input class="form-control" type="number" name="base" id="base"/>
                <p>Potencia</p>
                <input  class="form-control" type="number" name="potencia" id="potencia"/>
                <br>
                <input class="form-control" type="submit" name="send" value="Enviar"/>
                </div>
            </form>  
            <br>      
    
        <?php
              if(isset($_POST['base']) && isset($_POST['potencia'])):
            $base = isset($_POST['base']) ? $_POST['base'] : 0;
            $potencia = isset($_POST['potencia'])  ? $_POST['potencia'] : 0;  
            $resultado = pow( $base, $potencia ); 
            echo "$base elevado a $potencia es igual a $resultado";
            
        endif;
        ?>
        
        </fieldset>
    </div>
  </div>



  

  

   

</body>
</html>
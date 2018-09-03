<?php
    
    include "pais.php";
    $paises = array();
    
    $pais = new pais;
    $pais->nombre = "Costa Rica";
    $pais->poblacion = "24.895.000";
    $pais->extencion = "120.538 km2";
    $pais->uri = "http://flags.fmcdn.net/data/flags/w580/kp.png";
    $paises[]=$pais;

    $pais = new pais;
    $pais->nombre = "Guatemala";
    $pais->poblacion = "15.806.675";
    $pais->extencion = "108.889 km2";
    $pais->uri = "http://flags.fmcdn.net/data/flags/w580/gt.png";
    $paises[]=$pais;

    $pais = new pais;
    $pais->nombre = "Honduras";
    $pais->poblacion = "8.555.072";
    $pais->extencion = "112.088 km2";
    $pais->uri = "http://flags.fmcdn.net/data/flags/w580/hn.png";
    $paises[]=$pais;

    $pais = new pais;
    $pais->nombre = "El Salvador";
    $pais->poblacion = "6.340.000";
    $pais->extencion = "21.041 km2";
    $pais->uri = "http://flags.fmcdn.net/data/flags/w580/sv.png";
    $paises[]=$pais;

    $pais = new pais;
    $pais->nombre = "Panamá";
    $pais->poblacion = "3.405.813";
    $pais->extencion = "75.517 km2";
    $pais->uri = "http://flags.fmcdn.net/data/flags/w580/pa.png";
    $paises[]=$pais;


    if(isset($_POST['paises'])):

        header('Content-type: application/json');
    
        echo json_encode($paises);
        endif;

    if(isset($_POST['pais'])):

    $reporte = new pais;

    $nombre = isset($_POST['pais']) ? $_POST['pais'] : 0;
    foreach($paises as $valor){
        if($valor->nombre == $nombre){
            $reporte = $valor;
        }
    }
    header('Content-type: application/json');

	echo json_encode($reporte);
    endif;
?>

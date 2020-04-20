<%--
  Created by IntelliJ IDEA.
  User: Kike
  Date: 20/04/2020
  Time: 12:36 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="header.html"/>
<body id="formbody">
<div id="formdiv">
    <div id="formcontainer">
    <form class="form-horizontal" action="/AdminServlet" method="get">
        <fieldset>

            <!-- Form Name -->
            <legend>Agregar carro</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="marca">Marca</label>
                <div class="col-md-4">
                    <input id="marca" name="marca" type="text" placeholder="Marca del carro"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="linea">Linea</label>
                <div class="col-md-4">
                    <input id="linea" name="linea" type="text" placeholder="Linea del carro "
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="modelo">Modelo</label>
                <div class="col-md-4">
                    <input id="modelo" name="modelo" type="text" placeholder="Escriba el año del modelo"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="descripcion">Descripcion</label>
                <div class="col-md-4">
                    <input id="descripcion" name="descripcion" type="text" placeholder="Anote detalles del carro"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="parte1">Parte 1</label>
                <div class="col-md-4">
                    <input id="parte1" name="parte1" type="text" placeholder="anote la pieza"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="parte2">Parte 2</label>
                <div class="col-md-4">
                    <input id="parte2" name="parte2" type="text" placeholder="placeholder" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="parte4">Parte 4</label>
                <div class="col-md-4">
                    <input id="parte4" name="parte4" type="text" placeholder="placeholder" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="parte3">parte 3</label>
                <div class="col-md-4">
                    <input id="parte3" name="parte3" type="text" placeholder="placeholder" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="guardar">Guardar?</label>
                <div class="col-md-8">
                    <button type="submit" id="guardar" name="guardar" class="btn btn-success">Listo</button>
                    <button type="reset" id="cancelar" name="cancelar" class="btn btn-danger">Cancelar</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>

<jsp:include page="closing.html"/>
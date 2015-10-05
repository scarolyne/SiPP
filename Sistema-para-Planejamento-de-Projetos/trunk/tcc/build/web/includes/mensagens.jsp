<c:if test="${sessionScope.mensagemErro != null}">
    <div class="row">
        <div class="span8">
            <div class="alert alert-error">
                <button class="close" data-dismiss="alert" type="button">×</button>
                ${sessionScope.mensagemErro}
                <c:remove var="mensagemErro" scope="session" />
            </div>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.mensagemAlerta != null}">
    <div class="row">
        <div class="span8">
            <div class="alert alert-warning">
                <button class="close" data-dismiss="alert" type="button">×</button>
                ${sessionScope.mensagemAlerta}
                <c:remove var="mensagemAlerta" scope="session" />
            </div>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.mensagemSucesso != null}">
    <div class="row">
        <div class="span8">
            <div class="alert alert-success">
                <button class="close" data-dismiss="alert" type="button">×</button>
                ${sessionScope.mensagemSucesso}
                <c:remove var="mensagemSucesso" scope="session" />
            </div>
        </div>
    </div>
</c:if>
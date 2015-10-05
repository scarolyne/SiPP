<%-- 
    Document   : teste
    Created on : 15/11/2014, 14:12:08
    Author     : Carol
--%>

<%@ include file="/includes/config.jsp" %>

<c:if test="${titulo != null}">
    <script>
        parent.document.getElementById('editTitulo').innerHTML = '${titulo}';
        div = parent.document.getElementById('listaEquipe');
        div.innerHTML = "";
        <c:if test="${fn:length(equipe) gt 0}">
            html = "<tr>" +
                   "    <th colspan='3' style='text-align: center;'>Usuários Adicionados à Equipe</th>" +
                   "</tr>" +
                   "<tr>" +
                   "    <th>Usuário</th>" +
                   "    <th>Status</th>" +
                   "    <th style='text-align: center;'>Remover</th>" +
                   "<tr>";
            <c:forEach items="${equipe}" var="membroeq">
                html = html + "<tr>" +
                              "   <td>${membroeq.usuario.email}</td>" +
                              "   <td>${membroeq.cargo}</td>" +
                              "   <td style='text-align: center; font-size: 22px;'><a href='#' onclick=\"excluirUsuarioEquipe('${pageContext.request.contextPath}/Bootstrap/usuarioProjeto/excluir/id/${membroeq.usuario.id}/idProjeto/${membroeq.projeto.id}', '${membroeq.usuario.email}');\" rel='tooltip' data-original-title='Remover'><i class='icon-remove-sign'></i></a></td>" +
                              "</tr>";
            </c:forEach>
        </c:if>
        div.innerHTML = html;
    </script>
</c:if>
<c:if test="${idUsuarioEquipe != null}">
<script>
    if(${idUsuarioEquipe} == 0) {
        alert('E-mail não cadastrado!');
        parent.document.getElementById("${eok}").value = 0;
        parent.document.getElementById("email_${count}").focus();
    }
    else {
        parent.document.getElementById("usuario_${count}").value = ${idUsuarioEquipe};
        parent.document.getElementById("${eok}").value = 1;
    }
</script>
</c:if>
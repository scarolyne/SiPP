package utils;

/**
 *
 * @author ricobonfim
 */
public class Filtro {

    /**
     * Contem o nome do campo da tabela
     */
    String campo;
    /**
     * Contem o valor a ser comparado com o campo
     */
    String valor;
    /**
     * Variavel booleana para iniciar agrupamento Ex.: ( id = 1 OR id = 2 )
     */
    Boolean iniciaAgrupamento;
    /**
     * Variavel booleana para finalizar um agrupamento Ex.: ( id = 1 OR id = 2 )
     */
    Boolean finalizaAgrupamento;
    /**
     * Operador logico a ser utilizado na construcao do filtro
     * AND ou OR
     */
    String operador;
    /**
     * Tipo de operador a ser utilizado na comparacao entre campo e valor
     * Tipos disponiveis:
     * EQUAL,
     * NOT_EQUAL,
     * GREATER,
     * GREATER_EQUAL,
     * LOWER,
     * LOWER_EQUAL,
     * LIKELEFT,
     * LIKERIGHT,
     * LIKEALL,
     * LIKE,
     * NOTNULL,
     * NULL,
     * IN,
     * NOTIN
     */
    String tipo;

    public Filtro() {
        this.campo = "";
        this.valor = "";
        this.iniciaAgrupamento = false;
        this.finalizaAgrupamento = false;
        this.operador = "";
        this.tipo = "";
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo.trim();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor.trim();
    }

    public Boolean getIniciaAgrupamento() {
        return iniciaAgrupamento;
    }

    public void setIniciaAgrupamento(Boolean iniciaAgrupamento) {
        this.iniciaAgrupamento = iniciaAgrupamento;
    }

    public Boolean getFinalizaAgrupamento() {
        return finalizaAgrupamento;
    }

    public void setFinalizaAgrupamento(Boolean finalizaAgrupamento) {
        this.finalizaAgrupamento = finalizaAgrupamento;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador.trim();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.trim();
    }
}
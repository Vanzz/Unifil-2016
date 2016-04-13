
/**
 * Write a description of class ListaDinamicaSimples here.
 * 
 * @author Tiago Vansan Ketzer de Souza
 * @matricula 141041056
 */
public class Lista
{
    private Node inicio;

    /**
     * Constructor for objects of class ListaDinamicaSimples
     */
    public Lista()
    {
        this.inicio = null;
    }

    public void inserirInicio(Node _node){
        if(inicio == null){
            inicio = _node;
        }else{
            _node.setProximo(inicio);
            inicio = _node;
        }
    }

    public void inserirFinal(Node _node){
        if(inicio == null){
            inicio = _node;
            inicio.setAnterior(null);
        }else{
            Node aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(_node);
            _node.setAnterior(aux);
        }
    }

    public void inserir(int position, Node _node)
    {
        if(position == 1)
        {
            inicio = _node;
        }
        else if(position == getSize() + 1)
        {
            inserirFinal(_node);
        }
        else
        {
            _node.setProximo(getNode(position).getProximo());
            getNode(position - 1).setProximo(_node);
        }
    }

    public void remover(Node _node)
    {
        for(int i = 1; i <= getSize(); i++){
            if(getNode(i) == _node){
                remover(i); 
            }
        }
    }

    public void remover(int position)
    {
        if(position == 1) {
            inicio = inicio.getProximo();
        }
        else if(position == 1 && getSize() > 1){
            getNode(position+1).setAnterior(null);
            inicio = inicio.getProximo();
        }else if(position == getSize()){
            getNode(position-1).setProximo(null); 
        }else{
            getNode(position+1).setAnterior(getNode(position-1));
            getNode(position-1).setProximo(getNode(position+1));
        }
    }

    public Node getLast() {
        if(inicio == null){
            return inicio;
        }else{
            Node aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            return aux;
        }
    }

    public Node getNode(int position)
    {
        if(isEmpty() || position < 1 || position > getSize())
        {
            return null;
        }

        Node aux = inicio;

        for(int i = 1; i < position; i++)
        {
            aux = aux.getProximo();
        }

        return aux;
    }

    public int getNode(Node _node)
    {
        if(isEmpty())
        {
            return -1;
        }

        for(int i = 1; i < getSize(); i++)
        {
            if(getNode(i) == _node)
            {
                return i;
            }
        }

        return -1;
    }

    public void listAllNodes()
    {
        for(int i = 1; i <= getSize(); i++)
        {
            System.out.println(getNode(i)+"\nProx:\n->"+getNode(i).getProximo()+"\nAnt:->"+getNode(i).getAnterior());
        }
    }

    public Node getAnterior(Node _node) {
        Node aux = inicio;
        while(aux.getProximo() != _node) {
            aux = aux.getProximo();
        }
        return aux;
    }

    public int getSize()
    {
        int size = 1;
        Node lugar = inicio;

        if(isEmpty())
        {
            return 0;
        }else
        {
            while(lugar.getProximo() != null)
            {
                lugar = lugar.getProximo();
                size++;
            }
        }

        return size;
    }

    public void bubblesortAsc(){
        boolean troca = true;
        int j = 0;
        Node aux = inicio;
        while(aux.getProximo() != null){
            troca = false;
            System.out.println(aux.getIdade().getValue()+":"+Integer.parseInt(aux.getProximo().getIdade().getValue()));
            if (Integer.parseInt(aux.getIdade().getValue()) > Integer.parseInt(aux.getProximo().getIdade().getValue()))//if(a[i] > a[i+1])
            {
                Node tmp = aux;
                aux.setProximo(aux.getProximo().getProximo());

                getAnterior(aux).setProximo(aux.getProximo());

                tmp.getProximo().setProximo(aux);
            }
            aux = aux.getProximo();
        }
    }

    private void trocar(int i, int j)
    {
        // lista.getNode(i);
        // lista.getNode(j);

        // Node aux = lista.getNode(i);
        // lista.getNode(i).setProximo(lista.getNode(j));
        // lista.getNode(j).setProximo(aux);
    }

    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
}


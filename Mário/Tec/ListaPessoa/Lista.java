
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
        Node rolezero = inicio;
        Node rolezero2;
        Node alce = inicio;
        Node alceliar;
        // while(rolezero.getProximo() != null){
        // rolezero2 = rolezero;
        // while(rolezero2.getProximo() != null){
        // System.out.println(Integer.parseInt(rolezero.getIdade().getValue())+":"+Integer.parseInt(rolezero2.getProximo().getIdade().getValue()));
        // if(Integer.parseInt(rolezero.getIdade().getValue()) > Integer.parseInt(rolezero2.getProximo().getIdade().getValue())){

        // alce = rolezero;
        // alceliar = rolezero2;

        // trocar(alce, alceliar);
        // }
        // rolezero2 = rolezero2.getProximo();
        // }
        // rolezero = rolezero.getProximo();
        // }
        boolean troca = true;
        int j = 0;
        while(troca){
            troca = false;
            j++;
            for(int i = 1; i < getSize() - j; i++){
                if(Integer.parseInt(getNode(i).getIdade().getValue()) > Integer.parseInt(getNode(j).getIdade().getValue())){
                    trocar(getNode(i), getNode(j));
                }
            }
        }

        // for(int i = 1; i <= getSize(); i++) {
            // for(int j = i; j <= getSize(); j++){
                // System.out.println(Integer.parseInt(getNode(i).getIdade().getValue())+":"+Integer.parseInt(getNode(j).getIdade().getValue()));
                // System.out.println(getSize()+" i:"+i+" j:"+j);
                // System.out.println("inicio: "+inicio.getNome().getValue());
                // if(Integer.parseInt(getNode(i).getIdade().getValue()) > Integer.parseInt(getNode(j).getIdade().getValue())){
                    // trocar(getNode(i), getNode(j));
                // }
            // }
        // }
    }

    public void trocar(Node p, Node s) {
        Node pP = p.getProximo();
        Node pA = p.getAnterior();
        Node sP = s.getProximo();
        Node sA = s.getAnterior();

        p.setProximo(sP);
        p.setAnterior(s);
        s.setProximo(p);
        s.setAnterior(pA);

        arrumarPessoa(p, s);
    }

    public void arrumarPessoa (Node p, Node s) {
        int x, y;
        x = p.getNome().getX();
        y = p.getNome().getY();
        p.getNome().setLocation(s.getNome().getX(), s.getNome().getY());
        s.getNome().setLocation(x, y);
        x = p.getIdade().getX();
        y = p.getIdade().getY();
        p.getIdade().setLocation(s.getIdade().getX(), s.getIdade().getY());
        s.getIdade().setLocation(x, y);
        x = p.getPessoa().getX();
        y = p.getPessoa().getY();
        p.getPessoa().setLocation(s.getPessoa().getX(), s.getPessoa().getY());
        s.getPessoa().setLocation(x, y);
    }

    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
}


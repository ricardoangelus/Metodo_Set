import java.util.*;

public class List {

    public static void main(String[] args) {
        System.out.println("\nOrdem de inserção dos itens: ");
        Set<LinguagemFavorita> favorito = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Python",1991,"IDLE"));
            add(new LinguagemFavorita("Java",1991,"IntelliJ"));
            add(new LinguagemFavorita("Kotlin",2011,"IntelliJ"));
        }};
        for (LinguagemFavorita liguagemFavorita:favorito) System.out.println(liguagemFavorita.getNome() + " --> "
                + liguagemFavorita.getAnoCriacao() + " --> " + liguagemFavorita.getIde());

        System.out.println("\nOrdem natural dos itens: ");
        Set<LinguagemFavorita> favorito2 = new TreeSet<>(favorito);
        for (LinguagemFavorita liguagemFavorita:favorito2) System.out.println(liguagemFavorita.getNome() + " --> "
                + liguagemFavorita.getAnoCriacao() + " --> " + liguagemFavorita.getIde());


    }
}
class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private int anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return anoCriacao == that.anoCriacao && nome.equals(that.nome) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        int nome = CharSequence.compare(this.getNome(),linguagemFavorita.getNome());
        if (nome != 0) return nome;

        return this.getNome().compareTo(linguagemFavorita.getNome());

    }

}
class compareNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int ide = l1.getIde().compareTo(l2.getIde());
        if (ide != 0) return ide;

        return 0;
    }
}
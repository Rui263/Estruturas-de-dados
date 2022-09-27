package aulas.praticas.aulagit;

public class GitSheet {
    public static void main(String[] args) ""

        /**
         * git add 'nome do ficheiro' -pora passar de modified para staged
         * git commit -para passar de staged para commited
         *
         * git log --oneline -para ver histórico do projeto
         * git status -para ver o status do projeto, alterações/modificações
         * gitignore -para ignorar arquivos, escrevo dentro da pasta gitignore, tenho de a criar*
         *
         * git branch -mostra os branch's do projeto
         * git branch 'nome' -cria um novo branch com o nome especificado
         */
        System.out.println("Primeira linha do projeto git");
        /*
        git add . (ou posso colocar git add 'nome do arquivo', neste caso 'TestGit.java'
        git status
        git commit -m "mensagem do commit"
         */
        System.out.println("Segunda linha do projeto git");
/*
        git add .
        git status
        git commit -m "mensagem do commit"
         */
        System.out.println("Terceira linha do projeto git");
        /*
        git add .
        git status
        git commit -m "mensagem do commit"
         */
        //VOLTAR AO SEGUNDO COMMIT
        /*
        git checkout 1778564
         */
        //VOLTAR A TER TODOS OS REPOSITÓRIOS
        /*
        git checkout master
         */
        //REVERTER UM COMMIT
        /*
        git revert 1778564
         */
        //APAGAR OS COMMITS ATÉ AO SEGUNDO
        /*
        git reset 1778564
         */
    }
}

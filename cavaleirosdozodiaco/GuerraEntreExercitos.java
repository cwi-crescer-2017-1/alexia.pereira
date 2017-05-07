public class GuerraEntreExercitos {

    private ExercitoDeSaints exercito1;
    private ExercitoDeSaints exercito2;

    public GuerraEntreExercitos (ExercitoDeSaints exercito1, ExercitoDeSaints exercito2) {
        this.exercito1 = exercito1;
        exercito1.ordenar();
        this.exercito2 = exercito2;
        exercito2.ordenar();
    }

    public void iniciar () {
        while (! (this.exercito1.todos().isEmpty() || this.exercito2.todos().isEmpty())) {
            Batalha batalha = new Batalha (this.exercito1.get(0), this.exercito2.get(0));
            batalha.iniciar();
            this.exercito1.removerSaint(this.exercito1.get(0));
            this.exercito2.removerSaint(this.exercito2.get(0));
        }
    }
    
}

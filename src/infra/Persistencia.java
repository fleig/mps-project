package infra;

public class Persistencia implements IPersistencia{
    @Override
    public void readPersistencia() throws PersistenciaException {
        System.out.println("leitura");
    }

    @Override
    public void writePersistencia() throws PersistenciaException {
        System.out.println("escrita");
    }
}

package infra;

/**
 * Created by lucas on 17/10/16.
 */
public interface IPersistencia {
    public void readPersistencia() throws PersistenciaException;
    public void writePersistencia() throws PersistenciaException;
}

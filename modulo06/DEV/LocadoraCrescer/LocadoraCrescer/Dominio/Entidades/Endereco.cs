namespace LocadoraCrescer.Dominio.Entidades
{
    public class Endereco
    {
        public int Id { get; set; }
        public string Cidade { get; set; }
        public string Rua { get; set; }
        public int Numero { get; set; }
        public string UF { get; set; }
        public string CEP { get; set; }
    }
}
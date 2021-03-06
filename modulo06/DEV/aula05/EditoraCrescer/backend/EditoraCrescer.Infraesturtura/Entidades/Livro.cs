﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class Livro
    {
        public int Isbn { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public string Genero { get; set; }
        public DateTime? DataPublicacao { get; set; }
        public int IdAutor { get; set; }
        public Autor Autor { get; set; }
        public Usuario Revisor { get; set; }
        public int? IdUsuarioRevisor { get; set; }
        public DateTime? DataRevisão { get; set; }
        public string Capa { get; set; }

    }
}

namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 200),
                        Cpf = c.String(maxLength: 11),
                        DataNascimento = c.DateTime(nullable: false),
                        Genero = c.Int(nullable: false),
                        IdEndereco = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Endereco", t => t.IdEndereco, cascadeDelete: true)
                .Index(t => t.IdEndereco);
            
            CreateTable(
                "dbo.Endereco",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Cidade = c.String(),
                        Rua = c.String(),
                        Numero = c.String(),
                        UF = c.String(),
                        CEP = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Funcionario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Permissao = c.String(),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataLocacao = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaReal = c.DateTime(),
                        ValorLocacao = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorDesconto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdVeiculo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Veiculo", t => t.IdVeiculo, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdVeiculo);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Veiculo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Marca = c.String(),
                        Quantidade = c.Int(nullable: false),
                        Status = c.Boolean(nullable: false),
                        ValorDiario = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorAdicional = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoOpcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdLocacao = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Locacao", t => t.IdLocacao, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdLocacao)
                .Index(t => t.IdOpcional);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.LocacaoOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.LocacaoOpcional", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.Locacao", "IdVeiculo", "dbo.Veiculo");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco");
            DropIndex("dbo.LocacaoOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.LocacaoOpcional", new[] { "IdLocacao" });
            DropIndex("dbo.Locacao", new[] { "IdVeiculo" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropIndex("dbo.Cliente", new[] { "IdEndereco" });
            DropTable("dbo.Opcional");
            DropTable("dbo.LocacaoOpcional");
            DropTable("dbo.Veiculo");
            DropTable("dbo.Pacote");
            DropTable("dbo.Locacao");
            DropTable("dbo.Funcionario");
            DropTable("dbo.Endereco");
            DropTable("dbo.Cliente");
        }
    }
}

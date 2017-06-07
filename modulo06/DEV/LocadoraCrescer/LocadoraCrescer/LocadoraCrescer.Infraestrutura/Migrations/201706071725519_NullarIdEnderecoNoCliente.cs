namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class NullarIdEnderecoNoCliente : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco");
            DropIndex("dbo.Cliente", new[] { "IdEndereco" });
            AlterColumn("dbo.Cliente", "IdEndereco", c => c.Int());
            CreateIndex("dbo.Cliente", "IdEndereco");
            AddForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco");
            DropIndex("dbo.Cliente", new[] { "IdEndereco" });
            AlterColumn("dbo.Cliente", "IdEndereco", c => c.Int(nullable: false));
            CreateIndex("dbo.Cliente", "IdEndereco");
            AddForeignKey("dbo.Cliente", "IdEndereco", "dbo.Endereco", "Id", cascadeDelete: true);
        }
    }
}

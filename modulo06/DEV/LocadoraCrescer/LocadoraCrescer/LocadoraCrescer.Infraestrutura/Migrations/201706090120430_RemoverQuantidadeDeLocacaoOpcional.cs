namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverQuantidadeDeLocacaoOpcional : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.LocacaoOpcional", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.LocacaoOpcional", "IdOpcional", "dbo.Opcional");
            DropIndex("dbo.LocacaoOpcional", new[] { "IdLocacao" });
            DropIndex("dbo.LocacaoOpcional", new[] { "IdOpcional" });
            RenameColumn(table: "dbo.LocacaoOpcional", name: "IdLocacao", newName: "Locacao_Id");
            RenameColumn(table: "dbo.LocacaoOpcional", name: "IdOpcional", newName: "Opcional_Id");
            AlterColumn("dbo.LocacaoOpcional", "Locacao_Id", c => c.Int());
            AlterColumn("dbo.LocacaoOpcional", "Opcional_Id", c => c.Int());
            CreateIndex("dbo.LocacaoOpcional", "Locacao_Id");
            CreateIndex("dbo.LocacaoOpcional", "Opcional_Id");
            AddForeignKey("dbo.LocacaoOpcional", "Locacao_Id", "dbo.Locacao", "Id");
            AddForeignKey("dbo.LocacaoOpcional", "Opcional_Id", "dbo.Opcional", "Id");
            DropColumn("dbo.LocacaoOpcional", "Quantidade");
        }
        
        public override void Down()
        {
            AddColumn("dbo.LocacaoOpcional", "Quantidade", c => c.Int(nullable: false));
            DropForeignKey("dbo.LocacaoOpcional", "Opcional_Id", "dbo.Opcional");
            DropForeignKey("dbo.LocacaoOpcional", "Locacao_Id", "dbo.Locacao");
            DropIndex("dbo.LocacaoOpcional", new[] { "Opcional_Id" });
            DropIndex("dbo.LocacaoOpcional", new[] { "Locacao_Id" });
            AlterColumn("dbo.LocacaoOpcional", "Opcional_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.LocacaoOpcional", "Locacao_Id", c => c.Int(nullable: false));
            RenameColumn(table: "dbo.LocacaoOpcional", name: "Opcional_Id", newName: "IdOpcional");
            RenameColumn(table: "dbo.LocacaoOpcional", name: "Locacao_Id", newName: "IdLocacao");
            RenameColumn(table: "dbo.LocacaoOpcional", name: "Locacao_Id", newName: "Locacao_Id1");
            CreateIndex("dbo.LocacaoOpcional", "Locacao_Id1");
            CreateIndex("dbo.LocacaoOpcional", "IdOpcional");
            CreateIndex("dbo.LocacaoOpcional", "IdLocacao");
            AddForeignKey("dbo.LocacaoOpcional", "IdOpcional", "dbo.Opcional", "Id", cascadeDelete: true);
            AddForeignKey("dbo.LocacaoOpcional", "IdLocacao", "dbo.Locacao", "Id", cascadeDelete: true);
        }
    }
}

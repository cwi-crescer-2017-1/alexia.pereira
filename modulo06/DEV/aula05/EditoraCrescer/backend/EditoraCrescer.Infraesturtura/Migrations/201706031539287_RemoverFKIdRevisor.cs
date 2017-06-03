namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverFKIdRevisor : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Usuario");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            RenameColumn(table: "dbo.Livros", name: "IdRevisor", newName: "Revisor_Id");
            AlterColumn("dbo.Livros", "Revisor_Id", c => c.Int());
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Usuario", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Usuario");
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            AlterColumn("dbo.Livros", "Revisor_Id", c => c.Int(nullable: false));
            RenameColumn(table: "dbo.Livros", name: "Revisor_Id", newName: "IdRevisor");
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Usuario", "Id", cascadeDelete: true);
        }
    }
}

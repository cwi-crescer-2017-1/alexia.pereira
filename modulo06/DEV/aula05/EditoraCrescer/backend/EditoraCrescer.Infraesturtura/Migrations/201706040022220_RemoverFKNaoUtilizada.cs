namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverFKNaoUtilizada : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Permissao");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
        }
        
        public override void Down()
        {
        }
    }
}

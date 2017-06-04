namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class IdUsuarioRevisor : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "IdUsuarioRevisor", c => c.Int());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Livros", "IdUsuarioRevisor");
        }
    }
}

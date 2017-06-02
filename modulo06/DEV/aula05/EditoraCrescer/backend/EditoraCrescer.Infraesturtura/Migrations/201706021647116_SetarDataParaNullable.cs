namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SetarDataParaNullable : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime(nullable: false));
        }
    }
}

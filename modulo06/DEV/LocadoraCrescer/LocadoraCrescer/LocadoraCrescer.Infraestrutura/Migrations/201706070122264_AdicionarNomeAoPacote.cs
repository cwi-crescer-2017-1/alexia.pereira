namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarNomeAoPacote : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Pacote", "Nome", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Pacote", "Nome");
        }
    }
}

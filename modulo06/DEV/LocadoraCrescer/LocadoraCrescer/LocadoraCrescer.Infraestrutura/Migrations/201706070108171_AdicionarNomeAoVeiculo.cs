namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarNomeAoVeiculo : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Veiculo", "Nome", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Veiculo", "Nome");
        }
    }
}

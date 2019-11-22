using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using System;

namespace ef_demo
{
    public class TestContext : DbContext
    {
        public DbSet<Person> Person { get; set; }
        public DbSet<Address> Address { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
            => optionsBuilder
            .UseNpgsql("Host=localhost;Database=postgres;Username=postgres;Password=admin;Search Path=first_steps");

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var person = modelBuilder.Entity<Person>();
            person.HasKey(p => p.SSN);
            person.HasMany(p => p.Addresses).WithOne(a => a.Person).HasForeignKey(a => a.SSN);

            var address = modelBuilder.Entity<Address>();
            address.HasKey(a => new { a.SSN, a.AddressNo });
        }
    }

    public class Person
    {
        public string SSN { get; set; }
        public DateTime DateOfBirth { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public bool IsAwesome { get; set; }
        public double Awesomeness { get; set; }
        public decimal Wealth { get; set; }
        public List<Address> Addresses { get; set; }
    }

    public class Address
    {
        public string SSN { get; set; }
        public short AddressNo { get; set; }
        public string Country { get; set; }
        public string City { get; set; }
        public string Street { get; set; }
        public short StreetNo { get; set; }
        public Person Person { get; set; }
    }
}

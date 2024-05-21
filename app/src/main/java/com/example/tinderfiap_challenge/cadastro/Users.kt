package com.example.tinderfiap_challenge.cadastro

import com.example.tinderfiap_challenge.R

class UserManager {
    companion object {
        private val skillsToTeach = listOf(
            "REACT", "HTTP", "GESTAO DE PESSOAS", "CONTROLE DE PROCESSOS",
            "ANALITICS", "POWER BI", "AUTOMACAO", "WEB", "APIs Rest", "FIGMA"
        )

        private val skillsToLearn = listOf(
            "REACT", "HTTP", "GESTAO DE PESSOAS", "CONTROLE DE PROCESSOS",
            "ANALITICS", "POWER BI", "AUTOMACAO", "WEB", "APIs Rest", "FIGMA"
        )

        data class User(
            val name: String,
            val role: String,
            val description: String,
            val imageRes: Int,
            val skillsToTeach: List<String>,
            val skillsToLearn: List<String>,
            val isMentor: Boolean,
            val username: String,
            val password: String
        )

        fun getUsers(): List<User> {
            return listOf(
                User(
                    name = "Sara Adams",
                    role = "IT Manager",
                    description = "Gestão de Pessoas - Desenvolvimento Pessoal...",
                    imageRes = R.drawable.sara,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "sara.adams",
                    password = "123456"
                ),
                User(
                    name = "Camille Johnson",
                    role = "Software Engineer",
                    description = "Desenvolvimento de Software - Backend...",
                    imageRes = R.drawable.user0,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "camille.johnson",
                    password = "123456"
                ),
                User(
                    name = "John Doe",
                    role = "Product Manager",
                    description = "Gerenciamento de Produtos - Estratégia...",
                    imageRes = R.drawable.user1,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "john.doe",
                    password = "123456"
                ),
                User(
                    name = "Jane Smith",
                    role = "UX Designer",
                    description = "Design de Experiência do Usuário - Pesquisa...",
                    imageRes = R.drawable.user2,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "jane.smith",
                    password = "123456"
                ),
                User(
                    name = "Alice Brown",
                    role = "Data Scientist",
                    description = "Ciência de Dados - Machine Learning...",
                    imageRes = R.drawable.user3,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "alice.brown",
                    password = "123456"
                ),
                User(
                    name = "Robert Wilson",
                    role = "Marketing Specialist",
                    description = "Marketing Digital - SEO e SEM...",
                    imageRes = R.drawable.user4,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "robert.wilson",
                    password = "123456"
                ),
                User(
                    name = "Emily Davis",
                    role = "Financial Analyst",
                    description = "Análise Financeira - Investimentos...",
                    imageRes = R.drawable.user5,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "emily.davis",
                    password = "123456"
                ),
                User(
                    name = "Michael Johnson",
                    role = "Sales Manager",
                    description = "Gerenciamento de Vendas - Estratégias...",
                    imageRes = R.drawable.user6,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "michael.johnson",
                    password = "123456"
                ),
                User(
                    name = "Olivia Martinez",
                    role = "HR Specialist",
                    description = "Recursos Humanos - Recrutamento...",
                    imageRes = R.drawable.user7,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "olivia.martinez",
                    password = "123456"
                ),
                User(
                    name = "David Lee",
                    role = "Software Architect",
                    description = "Arquitetura de Software - Sistemas Distribuídos...",
                    imageRes = R.drawable.user8,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "david.lee",
                    password = "123456"
                ),
                User(
                    name = "Emma White",
                    role = "Operations Manager",
                    description = "Gerenciamento de Operações - Logística...",
                    imageRes = R.drawable.user9,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "emma.white",
                    password = "123456"
                ),
                User(
                    name = "James Harris",
                    role = "Business Analyst",
                    description = "Análise de Negócios - Processos...",
                    imageRes = R.drawable.user10,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "james.harris",
                    password = "123456"
                ),
                User(
                    name = "Sophia Clark",
                    role = "Graphic Designer",
                    description = "Design Gráfico - Branding...",
                    imageRes = R.drawable.user11,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "sophia.clark",
                    password = "123456"
                ),
                User(
                    name = "Benjamin Lewis",
                    role = "Network Engineer",
                    description = "Engenharia de Redes - Infraestrutura...",
                    imageRes = R.drawable.user12,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "benjamin.lewis",
                    password = "123456"
                ),
                User(
                    name = "Amelia Walker",
                    role = "Public Relations",
                    description = "Relações Públicas - Comunicação...",
                    imageRes = R.drawable.user13,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "amelia.walker",
                    password = "123456"
                ),
                User(
                    name = "William Hall",
                    role = "Project Manager",
                    description = "Gerenciamento de Projetos - Metodologias Ágeis...",
                    imageRes = R.drawable.user14,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "william.hall",
                    password = "123456"
                ),
                User(
                    name = "Mia Allen",
                    role = "Content Writer",
                    description = "Redação de Conteúdo - Estratégia de Conteúdo...",
                    imageRes = R.drawable.user15,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "mia.allen",
                    password = "123456"
                ),
                User(
                    name = "Lucas Young",
                    role = "Cybersecurity Analyst",
                    description = "Análise de Segurança Cibernética - Proteção de Dados...",
                    imageRes = R.drawable.user16,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "lucas.young",
                    password = "123456"
                ),
                User(
                    name = "Charlotte King",
                    role = "Customer Support",
                    description = "Suporte ao Cliente - Atendimento...",
                    imageRes = R.drawable.user17,
                    skillsToTeach = skillsToTeach.shuffled().take(3),
                    skillsToLearn = listOf(),
                    isMentor = true,
                    username = "charlotte.king",
                    password = "123456"
                ),
                User(
                    name = "Elijah Wright",
                    role = "Machine Learning Engineer",
                    description = "Engenharia de Machine Learning - IA...",
                    imageRes = R.drawable.user18,
                    skillsToTeach = listOf(),
                    skillsToLearn = skillsToLearn.shuffled().take(3),
                    isMentor = false,
                    username = "elijah.wright",
                    password = "123456"
                )
            )
        }
    }
}

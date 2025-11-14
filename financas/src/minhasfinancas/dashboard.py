import streamlit as st
import plotly.express as px

# Dados fornecidos
saldo = 16042.949993133545
receita = 23600.0
despesa = -7557.05

categorias = {
    "educacao": 895.0,
    "transporte": 259.1,
    "saude": 975.5,
    "lazer": 573.2,
    "diversos": 104.25,
    "moradia": 4750.0
}

# Configuração de página otimizada para mobile
st.set_page_config(
    layout="centered",  # deixa tudo centralizado e ideal para telas pequenas
    page_title="Dashboard Financeiro"
)

st.title("📊 Dashboard Financeiro (Mobile)")

# Métricas em coluna única para melhor visualização no celular
st.metric("Saldo", f"R$ {saldo:,.2f}")
st.metric("Receita", f"R$ {receita:,.2f}")
st.metric("Despesa", f"R$ {abs(despesa):,.2f}")

st.markdown("---")

# Gráfico de barras (ocupa largura total)
fig_bar = px.bar(
    x=list(categorias.values()),
    y=list(categorias.keys()),
    orientation='h',
    title="Despesas por Categoria"
)

st.plotly_chart(fig_bar, use_container_width=True)

# Gráfico de pizza (ocupa largura total)
fig_pizza = px.pie(
    names=["Receita", "Despesa"],
    values=[receita, abs(despesa)],
    title="Receita x Despesa"
)

st.plotly_chart(fig_pizza, use_container_width=True)

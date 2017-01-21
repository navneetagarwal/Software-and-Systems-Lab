PROJECT_ROOT=./
Q1DIR=$(PROJECT_ROOT)/question1
Q2DIR=$(PROJECT_ROOT)/question2
Q3DIR=$(PROJECT_ROOT)/question3
plot:
	@cd $(Q1DIR); \
	octave gradient_descent.m; \
	gnuplot plot.gnu
Project_proposal:
	@cd $(Q2DIR); \
	@pdflatex ProjectProposal
	@biber ProjectProposal
	@pdflatex ProjectProposal
	

GayatriMantra:
	@cd $(Q3DIR); \
		
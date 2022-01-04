namespace Lecture1DemoTickle
{
    partial class FrmTickle
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.BtnTouchMe = new System.Windows.Forms.Button();
            this.TmrShiver = new System.Windows.Forms.Timer(this.components);
            this.SuspendLayout();
            // 
            // BtnTouchMe
            // 
            this.BtnTouchMe.BackColor = System.Drawing.Color.Yellow;
            this.BtnTouchMe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnTouchMe.Location = new System.Drawing.Point(111, 114);
            this.BtnTouchMe.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.BtnTouchMe.Name = "BtnTouchMe";
            this.BtnTouchMe.Size = new System.Drawing.Size(171, 67);
            this.BtnTouchMe.TabIndex = 0;
            this.BtnTouchMe.Text = "Please click me!";
            this.BtnTouchMe.UseVisualStyleBackColor = false;
            this.BtnTouchMe.Click += new System.EventHandler(this.BtnTouchMe_Click);
            // 
            // TmrShiver
            // 
            this.TmrShiver.Tick += new System.EventHandler(this.TmrShiver_Tick);
            // 
            // FrmTickle
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Wheat;
            this.ClientSize = new System.Drawing.Size(379, 302);
            this.Controls.Add(this.BtnTouchMe);
            this.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.Name = "FrmTickle";
            this.Text = "A ticklish form";
            this.Load += new System.EventHandler(this.FrmTickle_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BtnTouchMe;
        private System.Windows.Forms.Timer TmrShiver;
    }
}

